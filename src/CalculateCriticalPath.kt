import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.set

/**
 * Acknowledgements:
 * We used the following website to figure out how to make the criticalPath algorithm:
 * https://www.geeksforgeeks.org/software-engineering-critical-path-method/
 * And our code is inspired by this solution on stack overflow:
 * https://stackoverflow.com/a/3022314
 */
class CalculateCriticalPath(selectedProject: Project) {
    var nodeList:ArrayList<CriticalNode> = ArrayList()
    var nodeMap:MutableMap<Task, CriticalNode> = mutableMapOf()
    var criticalPath = ArrayList<CriticalNode>()
    init{
        for(task:Task in selectedProject.tasks){
            val newNode = CriticalNode(task.name, task.timeFrame)
            nodeList.add(newNode)
            nodeMap[task] = newNode
        }

        for (task: Task in selectedProject.tasks) { //loop through all task objects
            val subTaskNameList: ArrayList<String> = task.subsequentTasks //get the tasks sub tasks
            for (subTaskName: String in subTaskNameList) { //loop through the strings of sub tasks
                for (subTask: Task in selectedProject.tasks) {
                    if (subTask.name == subTaskName) { //find the task object associated with the subtask string
                        nodeMap[task]!!.nextNodes.add(nodeMap[subTask]!!); //assign the subtask NODE to the task NODE
                        nodeMap[subTask]!!.previousNodes.add(nodeMap[task]!!); //assign the subtask NODE to the task NODE
                    }
                }
            }
        }

        val stepOneList = earliestStartFinishCalc(nodeList)
        val stepTwoList = latestStartFinishCalc(stepOneList)
        var completedPath = totalFloatCalc(stepTwoList)
        println("criticalPath: ")
        println(criticalPath)
    }

    /**
     * This is the first step towards obtaining the critical path
     * It goes forward through all the nodes (tasks) to assign the earliest finish and earliest start
     *
     * @param nodeList The list of nodes to be used for this algorithm
     * @return returns the completed list with earliestFinish and earliestStart of each node
     */
    private fun earliestStartFinishCalc(nodeList: ArrayList<CriticalNode>?): ArrayList<CriticalNode> {
        val completed = HashSet<CriticalNode>()
        val remaining = HashSet(nodeList)
        //while the remaining list still has nodes, keep looping
        while (remaining.isNotEmpty()) {
            var progress = false //progress is reset to false
            //Create iterator for remaining list
            val it = remaining.iterator()
            while (it.hasNext()) { //loop while remaining has nodes
                val node = it.next() //assign the next node in the remaining list to node
                //Check if all the previous nodes of the current node we're looking at, are already completed, if not, skip this node
                if (completed.containsAll(node.previousNodes)) {
                    var critical = 0 //reset to 0
                    //loop through all the previous nodes and find the one with the highest earliest finish
                    for (t in node.previousNodes) {
                        if (t.earliestFinish > critical) {
                            critical = t.earliestFinish
                        }
                    }
                    //the earliest finish of the current node, is that of the highest previous node plus this node's duration
                    node.earliestFinish = critical + node.duration
                    node.earliestStart = critical
                    //remove the current node from the remaining list and add to completed list
                    completed.add(node)
                    it.remove()
                    //progress has been made this loop
                    progress = true
                }
            }
            //if no progress was made after analysing the whole list of nodes, then we're likely stuck in an infinite loop. Throw an exception
            if (!progress) throw RuntimeException("Algorithm likely stuck in infinite loop")
        }
        //return the completed hashSet as an ArrayList so that it can be passed on to the next function
        return completed.toCollection(ArrayList())
    }

    /**
     * This is the second step of the algorithm. Here it goes backwards through the nodes from end to start
     * This way it finds the latestFinish and latestStart of each node. It is similar to the previous function
     *
     * @param nodeList The list of nodes to be used for this algorithm, must have earliestFinish defined
     * @return returns the completed list with latestFinish and latestStart of each node
     */
    private fun latestStartFinishCalc(nodeList: ArrayList<CriticalNode>?): ArrayList<CriticalNode> {
        val completed = HashSet<CriticalNode>()
        val remaining = HashSet(nodeList)
        var maxEarliestFinish = 0 //This is the earliest finish value of the entire project (and therefore the highest of any node)

        //find highest value of earliestFinish of any node, this will be the earliestFinish of the whole project.
        for(node in remaining) {
            if (maxEarliestFinish < node.earliestFinish) {
                maxEarliestFinish = node.earliestFinish
            }
        }
        //while the remaining list still has nodes, keep looping
        while (remaining.isNotEmpty()) {
            var progress = false //progress is reset to false
            //Create iterator for remaining list
            val it = remaining.iterator()
            while (it.hasNext()) { //loop while remaining has nodes
                val node = it.next() //set node to the next node in the remaining list
                if (completed.containsAll(node.nextNodes)) {
                    //The latestFinish is equal to the lowest latestStart of the node in front of the current node.
                    //To find the lowest, we initially set minLatestStart to the highest possible Finish of the project
                    var minLatestStart = maxEarliestFinish
                    //if the current node is one of the last nodes, their latest finish is equal to the project's earliest finish
                    if(node.nextNodes.size == 0){
                        node.latestFinish = maxEarliestFinish
                        node.latestStart = maxEarliestFinish - node.duration
                    } else {
                        for (t in node.nextNodes) {
                            if (t.latestStart < minLatestStart) {
                                //find minLatestStart, and set it to the lowest value of all nodes in front of the current node
                                minLatestStart = t.latestStart
                            }
                        }
                        node.latestFinish = minLatestStart
                        //latestStart is equal to the latestStart - the duration of the current node
                        node.latestStart = minLatestStart - node.duration
                    }
                    //remove the current node from the remaining list and add to completed list
                    completed.add(node)
                    it.remove()
                    //progress has been made this loop
                    progress = true

                }
            }
            //if no progress was made after analysing the whole list of nodes, then we're likely stuck in an infinite loop. Throw an exception
            if (!progress) throw RuntimeException("Algorithm likely stuck in infinite loop")
        }
        //return the completed hashSet as an ArrayList so that it can be passed on to the next function
        return completed.toCollection(ArrayList())
    }

    /**
     * This function calculates the totalFloat by subtracting earliestFinish from latestFinish
     * It then finds the critical nodes, and puts them in the correct order in the criticalPath array
     *
     * @param nodeList The list of nodes to be used for this algorithm, must have earliestFinish and latestFinish defined
     */
    private fun totalFloatCalc(nodeList: ArrayList<CriticalNode>?): ArrayList<CriticalNode>{
        //List of all the nodes that are part of the critical path, but not in the correct order
        val criticalNodes = ArrayList<CriticalNode>()
        //Loop through all the nodes and find the ones that have a totalFloat of 0, these are part of the critical path
        for(node in nodeList!!){
            node.totalFloat = node.latestFinish-node.earliestFinish
            if(node.totalFloat == 0){
                criticalNodes.add(node)
            }
        }
        var startingNode: CriticalNode? = null
        //find the starting node by looping through all critical nodes and checking which one has no previous nodes
        for(node in criticalNodes){
            if(node.previousNodes.size == 0){
                startingNode = node
            }
        }
        //add the starting node to the criticalPath
        criticalPath = arrayListOf(startingNode!!)
        findNextNode(startingNode)

        return criticalPath
    }
    /**
     * Recursive function to find out the order of the critical nodes in the criticalPath
     * It directly changes the criticalPath variable so that it is easy to access through the Java GUI
     *
     * @param node Current node of which the next node needs to be found
     */
    private fun findNextNode(node:CriticalNode){
        //Loop through all next nodes
        for(nextNode in node.nextNodes){
            //If nextNode is on the critical path, add it to the path and find its next critical node
            if(nextNode.totalFloat == 0){
                criticalPath.add(nextNode)
                findNextNode(nextNode)
            }
        }
    }
}

