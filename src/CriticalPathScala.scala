import java.util

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Map}
class CriticalPathScala {
  /*
    var name:String,
    var duration:Int
    var earliestStart:Int = 0       //earliest start time for task
    var earliestFinish:Int = 0      //earliest finish time for task
    var latestStart:Int = 0         //latest start time
    var latestFinish:Int =0         //latest finish time
    var totalFloat:Int =0           //difference between earliestStart and latestStart (start wiggle room)
    var previousNodes:ArrayList<CriticalNode> = ArrayList()
    var nextNodes:ArrayList<CriticalNode> = ArrayList()
    ("previousNodes", Seq()), ("nextNodes", Seq())
  */

  def start(selectedProject:Project): Unit ={
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
        println("a")
        //subsequentTaskList.addOne(subsequentNode)
      }
      //nodeList(task.getName)("nextNodes") = subsequentTaskList
    }
    println(nodeList("A")("totalFloat"))
  }
}
