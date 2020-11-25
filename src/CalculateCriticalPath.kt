import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.set


class CalculateCriticalPath(selectedProject: Project) {
    var nodeList:ArrayList<CriticalNode> = ArrayList()
    var nodeMap:MutableMap<Task, CriticalNode> = mutableMapOf()
    var startingList:ArrayList<CriticalNode> = ArrayList()
    var criticalPath = ArrayList<CriticalNode>()
    init{
        for(task:Task in selectedProject.tasks){
            var newNode:CriticalNode = CriticalNode(task.name, task.timeFrame)
            nodeList.add(newNode)
            nodeMap[task] = newNode

        }

        for (task: Task in selectedProject.tasks) { //loop through all task objects
            var subTaskNameList: ArrayList<String> = task.subsequentTasks //get the tasks sub tasks
            for (subTaskName: String in subTaskNameList) { //loop through the strings of sub tasks
                for (subTask: Task in selectedProject.tasks) {
                    if (subTask.name == subTaskName) { //find the task object associated with the subtask string
                        nodeMap[task]!!.nextNodes.add(nodeMap[subTask]!!); //assign the subtask NODE to the task NODE
                        nodeMap[subTask]!!.previousNodes.add(nodeMap[task]!!); //assign the subtask NODE to the task NODE
                    }
                }
            }
        }

        /*for(node:CriticalNode in nodeList){
            if(node.previousNodes.size<1){
                node.earliestStart = 0
                startingList.add(node) //if a node has no previous nodes, add it to the starting list
                calculateNextStep(node)
            }
        }*/
        var aaaaaaaaaaa = earliestStartFinishCalc(nodeList)
        println("Earliest: ")
        print(aaaaaaaaaaa)
        var bbbbbbbb = latestStartFinishCalc(aaaaaaaaaaa)
        println("Latest: ")
        print(bbbbbbbb)
        var completedPath = totalFloatCalc(bbbbbbbb)
        println("completed: ")
        print(completedPath)
        println("criticalPath: ")
        println(criticalPath)
    }
    private fun calculateNextStep(node:CriticalNode){
        if(node.earliestStart==0){
            node.earliestFinish = node.duration

        }else{
            if(node.nextNodes.size>1){
                var longestNode:CriticalNode = node.nextNodes[0]
                for(item:CriticalNode in node.nextNodes){
                    if(longestNode.earliestFinish<item.earliestFinish){
                        longestNode = item
                    }
                }
            }
            //node.earliestStart = node.previousNodes
        }
    }

    fun earliestStartFinishCalc(tasks: ArrayList<CriticalNode>?): ArrayList<CriticalNode> {
        //tasks whose critical cost has been calculated
        val completed = HashSet<CriticalNode>()
        //tasks whose ciritcal cost needs to be calculated
        val remaining = HashSet(tasks) //TODO change so it looks less stolen
        var maxEarliestFinish = 0
        //Backflow algorithm
        //while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            var progress = false
            //find a new task to calculate
            val it = remaining.iterator()
            while (it.hasNext()) {
                val node = it.next()
                if (completed.containsAll(node.previousNodes)) {
                    //all dependencies calculated, critical cost is max dependency
                    //critical cost, plus our cost
                    var critical = 0
                    for (t in node.previousNodes) {
                        if (t.earliestFinish > critical) {
                            critical = t.earliestFinish
                        }
                    }
                    node.earliestFinish = critical + node.duration
                    node.earliestStart = critical
                    //set task as calculated an remove
                    completed.add(node)
                    it.remove()
                    //note we are making progress

                    progress = true
                }
            }
            //If we haven't made any progress then a cycle must exist in
            //the graph and we wont be able to calculate the critical path
            if (!progress) throw RuntimeException("Cyclic dependency, algorithm stopped!")
        }


        return completed.toCollection(ArrayList())
    }
    //TODO IMPORTANT
    fun latestStartFinishCalc(tasks: ArrayList<CriticalNode>?): ArrayList<CriticalNode> {
        //tasks whose critical cost has been calculated
        val completed = HashSet<CriticalNode>()
        //tasks whose ciritcal cost needs to be calculated
        val remaining = HashSet(tasks)
        var maxEarliestFinish = 0
        //Backflow algorithm
        //while there are tasks whose critical cost isn't calculated.
        for(node in remaining) {
            if (maxEarliestFinish < node.earliestFinish) {
                maxEarliestFinish = node.earliestFinish
            }
        }
        println("earliest: $maxEarliestFinish, remaining: $remaining")
        while (!remaining.isEmpty()) {
            var progress = false

            //find a new task to calculate
            val it = remaining.iterator()
            while (it.hasNext()) {
                val node = it.next()
                if (completed.containsAll(node.nextNodes)) {
                    //all dependencies calculated, critical cost is max dependency
                    //critical cost, plus our cost
                    var critical = maxEarliestFinish
                    if(node.nextNodes.size == 0){
                        node.latestFinish = maxEarliestFinish
                        node.latestStart = maxEarliestFinish - node.duration
                    } else {
                        for (t in node.nextNodes) {
                            if (t.latestStart < critical) {
                                critical = t.latestStart
                            }
                        }
                        node.latestStart = critical - node.duration
                        node.latestFinish = critical
                        //set task as calculated an remove
                    }
                    completed.add(node)
                    it.remove()
                    //note we are making progress
                    progress = true

                }
            }
            //If we haven't made any progress then a cycle must exist in
            //the graph and we wont be able to calculate the critical path
            if (!progress) throw RuntimeException("Cyclic dependency, algorithm stopped!")
        }

        //get the tasks
        val ret: Array<CriticalNode> = completed.toArray(arrayOfNulls(0))
        //create a priority list

        return completed.toCollection(ArrayList())
    }

    fun totalFloatCalc(tasks: ArrayList<CriticalNode>?): ArrayList<CriticalNode>{
        val completed = ArrayList<CriticalNode>()
        val remaining = HashSet(tasks)
        var criticalNodes = ArrayList<CriticalNode>()
        for(node in remaining){
            node.totalFloat = node.latestFinish-node.earliestFinish
            completed.add(node)
            if(node.totalFloat == 0){
                criticalNodes.add(node)
            }
        }
        var startingNode: CriticalNode? = null
        for(node in criticalNodes){
            if(node.previousNodes.size == 0){
                startingNode = node
            }
        }
        criticalPath = arrayListOf(startingNode!!)
        findNextNode(startingNode!!)
        /*var criticalPath = arrayListOf(startingNode!!)
        var nextNode = startingNode
        for(i in 0 until criticalNodes.size){
            for(anotherNode in nextNode!!.nextNodes){
                if(anotherNode.totalFloat == 0){
                    criticalPath.add(anotherNode)
                    nextNode = anotherNode
                }
            }
        }*/
        return completed
    }
    fun findNextNode( node:CriticalNode){
        for(nextNode in node.nextNodes){
            if(nextNode.totalFloat == 0){
                criticalPath.add(nextNode)
                findNextNode(nextNode)
            }
        }
    }
}

