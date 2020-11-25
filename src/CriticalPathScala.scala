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
  */

  def start(selectedProject:Project): Unit ={
    val nodeList:ArrayBuffer[Map[String, Any]] = ArrayBuffer()
    val node1: Map[String, Any] = Map(("name","Henk"),("duration",0),("earliestStart",0),("earliestFinish",0),("latestStart",0),("latestFinish",0),("totalFloat",10), ("previousNodes", Seq()),("nextNodes", Seq()) )
    val node2: Map[String, Any] = Map(("name","Henk"),("duration",0),("earliestStart",0),("earliestFinish",0),("latestStart",0),("latestFinish",0),("totalFloat",20), ("previousNodes", Seq(node1)),("nextNodes", Seq()) )
    val node3: Map[String, Any] = Map(("name","Henk"),("duration",0),("earliestStart",0),("earliestFinish",0),("latestStart",0),("latestFinish",0),("totalFloat",30), ("previousNodes", Seq(node2)),("nextNodes", Seq()) )
    node2("nextNodes") = Seq(node3)
    nodeList+=node1
    nodeList+=node2
    nodeList+=node3
    println(nodeList(1)("totalFloat"))
  }
}
