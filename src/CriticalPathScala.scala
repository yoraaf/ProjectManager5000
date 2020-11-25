import java.util

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Map}
import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}
class CriticalPathScala {
  var criticalPath: ArrayBuffer[mutable.Map[String, Any]] = ArrayBuffer[mutable.Map[String, Any]]()
  def start(selectedProject:Project): ArrayBuffer[mutable.Map[String, Any]] ={
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
      val subsequentTaskList = ArrayBuffer[mutable.Map[String, Any]]()
      val subsequentNameList = task.getSubsequentTasks
      for(i <- 0 until subsequentNameList.size){
        val subsequentNode = nodeList(task.getSubsequentTasks.get(i))

        //currentNode("nextNodes") = Seq(currentNode("nextNodes"), subsequentNode)
        //subsequentNode("previousNodes") = Seq(subsequentNode("previousNodes"), nodeList(task.getName))
        currentNode("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]].addOne(subsequentNode)
        subsequentNode("previousNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]].addOne(currentNode)
        //println("a")
        //subsequentTaskList.addOne(subsequentNode)
      }
      //nodeList(task.getName)("nextNodes") = subsequentTaskList
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
    criticalPath
  }

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

  def earliestStartFinishCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]): ArrayBuffer[mutable.Map[String, Any]] ={
    val completed = ArrayBuffer[mutable.Map[String, Any]]()
    val remaining = nodeList.asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]

    while(remaining.nonEmpty){
      var progress = false

      var it = remaining.iterator
      breakable {
        for (node <- remaining) {
          //val node = it.next()
          if(node == null){
            break
          }
          println("test")
          println(node("name").asInstanceOf[String])
          var test = node("previousNodes")
          val previousNodes = node("previousNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]

          var isPreviousDone = 0
          if(previousNodes.nonEmpty) {
            for (n <- previousNodes) {
              if (completed.contains(n) && (isPreviousDone == 0 || isPreviousDone == 1)) {
                isPreviousDone = 1
              } else {
                isPreviousDone = 2
              }
            }
          } else{
            isPreviousDone = 1
          }
          if (containsAll(previousNodes, completed)) {
            var critical: Int = 0

            for (previousNode <- previousNodes) {
              if (previousNode("earliestFinish").asInstanceOf[Int] > critical) {
                critical = previousNode("earliestFinish").asInstanceOf[Int]
              }
            }
            node("earliestFinish") = critical + node("duration").asInstanceOf[Int]
            node("earliestStart") = critical

            completed.addOne(node)
            remaining.remove(remaining.indexOf(node))

            progress = true
          }
        }
      }

        if (!progress) {
          println("No progress")
          throw new Exception("Algorithm likely stuck in infinite loop")
        }
    }
    completed
  }
  def latestStartFinishCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]):ArrayBuffer[mutable.Map[String,Any]]={
    val completed = ArrayBuffer[mutable.Map[String, Any]]()
    val remaining = nodeList.asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
    var maxEarliestFinish = 0

    for(node <- remaining){
      if (maxEarliestFinish < node("earliestFinish").asInstanceOf[Int]) {
        maxEarliestFinish = node("earliestFinish").asInstanceOf[Int]
      }
    }

    while(remaining.nonEmpty){
      var progress = false

      val it = remaining.iterator
      breakable {
        for (node <- remaining) {
          //val node = it.next()
          if(node == null){
            break
          }
          val nextNodes = node("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]
          //val previousNodes = node("previousNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]

          if (containsAll(nextNodes, completed)) {

            var minLatestStart = maxEarliestFinish

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
            node("latestStart") = minLatestStart - node("duration").asInstanceOf[Int]

            completed.addOne(node)
            remaining.remove(remaining.indexOf(node))

            progress = true
          }
        }
        try {
          if (!progress) {
            println("error in step 2")
            throw new Exception("Algorithm likely stuck in infinite loop")
          }
        }
        println("loop")
      }
    }
    completed
  }
  def totalFloatCalc(nodeList:ArrayBuffer[mutable.Map[String, Any]]): Unit ={
    val criticalNodes = ArrayBuffer[mutable.Map[String, Any]]()

    for (node <- nodeList){
      node("totalFloat") = node("latestFinish").asInstanceOf[Int] - node("earliestFinish").asInstanceOf[Int]
      if(node("totalFloat").asInstanceOf[Int] == 0){
        criticalNodes.addOne(node)
      }
    }
    var startingNode = mutable.Map[String, Any]()

    for(node <- criticalNodes){
      if(node("previousNodes").asInstanceOf[ArrayBuffer[Any]].isEmpty){
        startingNode = node
      }
    }
    criticalPath.addOne(startingNode)
    findNextNode(startingNode)
  }

  def findNextNode(node:mutable.Map[String, Any]): Unit ={
    for(nextNode <- node("nextNodes").asInstanceOf[ArrayBuffer[mutable.Map[String, Any]]]){
      if(nextNode("totalFloat").asInstanceOf[Int] == 0) {
        criticalPath.addOne(nextNode)
        findNextNode(nextNode)
      }
    }
  }

}
