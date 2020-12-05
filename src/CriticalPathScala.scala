import java.util

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Map}
import scala.util.control.Breaks.{break, breakable}
import scala.jdk.CollectionConverters._
class CriticalPathScala {
  var criticalPath: ArrayBuffer[mutable.Map[String, Any]] = ArrayBuffer[mutable.Map[String, Any]]()

  def start(selectedProject:Project): util.Collection[util.Map[String, Any]] ={
    val nodeList:mutable.Map[String, mutable.Map[String, Any]] = mutable.Map()

    for(i <- 0 until selectedProject.getTasks.size){
      val task = selectedProject.getTasks.get(i)
      val node1: mutable.Map[String, Any] = mutable.Map(("name", task.getName), ("duration", task.getTimeFrame),
        ("earliestStart", 0), ("earliestFinish", 0), ("latestStart", 0), ("latestFinish", 0), ("totalFloat", 0),
        ("previousNodes", ArrayBuffer[mutable.Map[String, Any]]()), ("nextNodes", ArrayBuffer[mutable.Map[String, Any]]()))
      nodeList.addOne(task.getName,node1)
    }
    for(i <- 0 until selectedProject.getTasks.size){
      val task = selectedProject.getTasks.get(i)
      val currentNode = nodeList(task.getName)
      val subsequentNameList = task.getSubsequentTasks
      for(i <- 0 until subsequentNameList.size){
        val subsequentNode = nodeList(task.getSubsequentTasks.get(i))

        currentNode("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]].addOne(subsequentNode)
        subsequentNode("previousNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]].addOne(currentNode)
      }
    }
    val nodeListArray = ArrayBuffer[mutable.Map[String, Any]]()
    for(n <- nodeList.toArray){
      val x = n.productIterator.toList
      nodeListArray.addOne(x(1).asInstanceOf[mutable.Map[String, Any]])
    }
    val resultOne = earliestStartFinishCalc(nodeListArray)
    println("resultOne")
    val resultTwo = latestStartFinishCalc(resultOne)
    println("resultTwo")
    totalFloatCalc(resultTwo)
    println("done")
    val criticalJavaPath = ArrayBuffer[util.Map[String, Any]]()
    for(node <- criticalPath){
      criticalJavaPath.addOne(node.asJava)
    }
    criticalJavaPath.asJavaCollection
  }

  /**
   * Custom contains all function as one is not available in Scala
   * @param previousNodes
   * @param completed
   * @return
   */

  def containsAll(previousNodes:ArrayBuffer[mutable.Map[String, Any]], completed:ArrayBuffer[mutable.Map[String, Any]]): Boolean = {
    if (previousNodes.nonEmpty) {
      for (n <- previousNodes) {
        if (!completed.contains(n)) {
          return false
        }
      }
      true
    } else {true}
  }

  /**
   * This is the first step towards obtaining the critical path
   * It goes forward through all the nodes (tasks) to assign the earliest finish and earliest start
   *
   * @param nodeList The list of nodes to be used for this algorithm
   * @return
   */

  def earliestStartFinishCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]): ArrayBuffer[mutable.Map[String, Any]] ={
    val completed = ArrayBuffer[mutable.Map[String, Any]]()
    val remaining = nodeList.asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
    //while the remaining list still has nodes, keep looping
    while(remaining.nonEmpty){
      var progress = false //progress is reset to false
      breakable {
        for (node <- remaining) { //breakable for loop
          if(node == null){ // if null the loop can break
            break
          }
          val previousNodes = node("previousNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
          //Check if all the previous nodes of the current node we're looking at, are already completed, if not, skip this node
          if (containsAll(previousNodes, completed)) {
            var critical: Int = 0 //reset to 0
            //loop through all the previous nodes and find the one with the highest earliest finish
            for (previousNode <- previousNodes) {
              if (previousNode("earliestFinish").asInstanceOf[Int] > critical) {
                critical = previousNode("earliestFinish").asInstanceOf[Int]
              }
            }
            //the earliest finish of the current node, is that of the highest previous node plus this node's duration
            node("earliestFinish") = critical + node("duration").asInstanceOf[Int]
            node("earliestStart") = critical
            //remove the current node from the remaining list and add to completed list
            completed.addOne(node)
            remaining.remove(remaining.indexOf(node))
            //progress has been made this loop
            progress = true
          }
        }
      }
        //if no progress was made after analysing the whole list of nodes, then we're likely stuck in an infinite loop. Throw an exception
        if (!progress) {
          println("No progress")
          throw new Exception("Algorithm likely stuck in infinite loop")
        }
    }
    //returns ArrayBuffer so that it can be passed onto the next function
    completed
  }

  /**
   * This is the second step of the algorithm. Here it goes backwards through the nodes from end to start
   * This way it finds the latestFinish and latestStart of each node. It is similar to the previous function
   *
   * @param nodeList The list of nodes to be used for this algorithm, must have earliestFinish defined
   * @return
   */
  def latestStartFinishCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]):ArrayBuffer[mutable.Map[String,Any]]={
    val completed = ArrayBuffer[mutable.Map[String, Any]]()
    val remaining = nodeList.asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
    var maxEarliestFinish = 0 //This is the earliest finish value of the entire project (and therefore the highest of any node)

    //find highest value of earliestFinish of any node, this will be the earliestFinish of the whole project.
    for(node <- remaining){
      if (maxEarliestFinish < node("earliestFinish").asInstanceOf[Int]) {
        maxEarliestFinish = node("earliestFinish").asInstanceOf[Int]
      }
    }
    //while the remaining list still has nodes, keep looping
    while(remaining.nonEmpty){
      var progress = false //progress is reset to false
      breakable {
        for (node <- remaining) { //breakable for loop
          if(node == null){ //breaks if node is null
            break
          }
          //set node to the next node in the remaining list
          val nextNodes = node("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
          if (containsAll(nextNodes, completed)) {
            //The latestFinish is equal to the lowest latestStart of the node in front of the current node.
            //To find the lowest, we initially set minLatestStart to the highest possible Finish of the project
            var minLatestStart = maxEarliestFinish
            //if the current node is one of the last nodes, their latest finish is equal to the project's earliest finish
            if (node("nextNodes").asInstanceOf[ArrayBuffer[Any]].isEmpty) {
              node("latestFinish") = maxEarliestFinish
              node("latestStart") = maxEarliestFinish - node("duration").asInstanceOf[Int]
            } else {
              for (nextNode <- nextNodes) {
                if (nextNode("latestStart").asInstanceOf[Int] < minLatestStart) {
                  minLatestStart = nextNode("latestStart").asInstanceOf[Int]
                }
              }
            }
            node("latestFinish") = minLatestStart
            //latestStart is equal to the latestStart - the duration of the current node
            node("latestStart") = minLatestStart - node("duration").asInstanceOf[Int]

            //remove the current node from the remaining list and add to completed list
            completed.addOne(node)
            remaining.remove(remaining.indexOf(node))
            //progress has been made this loop
            progress = true
          }
        }
        //if no progress was made after analysing the whole list of nodes, then we're likely stuck in an infinite loop. Throw an exception
        try {
          if (!progress) {
            println("error in step 2")
            throw new Exception("Algorithm likely stuck in infinite loop")
          }
        }
      }
    }
    // return as an ArrayBuffer to be fed into the next function
    completed
  }

  /**
   * This function calculates the totalFloat by subtracting earliestFinish from latestFinish
   * It then finds the critical nodes, and puts them in the correct order in the criticalPath array
   *
   * @param nodeList The list of nodes to be used for this algorithm, must have earliestFinish and latestFinish defined
   */
  def totalFloatCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]): Unit ={
    //List of all the nodes that are part of the critical path, but not in the correct order
    val criticalNodes = ArrayBuffer[mutable.Map[String, Any]]()
    //Loop through all the nodes and find the ones that have a totalFloat of 0, these are part of the critical path
    for (node <- nodeList){
      node("totalFloat") = node("latestFinish").asInstanceOf[Int] - node("earliestFinish").asInstanceOf[Int]
      if(node("totalFloat").asInstanceOf[Int] == 0){
        criticalNodes.addOne(node)
      }
    }
    var startingNode = mutable.Map[String, Any]()
    //find the starting node by looping through all critical nodes and checking which one has no previous nodes
    for(node <- criticalNodes){
      if(node("previousNodes").asInstanceOf[ArrayBuffer[Any]].isEmpty){
        startingNode = node
      }
    }
    //add the starting node to the criticalPath
    criticalPath.addOne(startingNode)
    findNextNode(startingNode)
  }

  /**
   * Recursive function to find out the order of the critical nodes in the criticalPath
   * It directly changes the criticalPath variable so that it is easy to access through the Java GUI
   *
   * @param node Current node of which the next node needs to be found
   */
  def findNextNode(node:mutable.Map[String, Any]): Unit ={
    //Loop through all next nodes
    for(nextNode <- node("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]){
      //If nextNode is on the critical path, add it to the path and find its next critical node
      if(nextNode("totalFloat").asInstanceOf[Int] == 0) {
        criticalPath.addOne(nextNode)
        findNextNode(nextNode)
      }
    }
  }

}
