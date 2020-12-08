class CriticalNode(var name:String, var duration:Int) {
    var earliestStart:Int = 0       //earliest start time for task
    var earliestFinish:Int = 0      //earliest finish time for task
    var latestStart:Int = 0         //latest start time
    var latestFinish:Int =0         //latest finish time
    var totalFloat:Int =0           //difference between earliestStart and latestStart (start wiggle room)
    var previousNodes:ArrayList<CriticalNode> = ArrayList()
    var nextNodes:ArrayList<CriticalNode> = ArrayList()
}