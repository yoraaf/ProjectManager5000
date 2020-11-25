class CriticalNode(var name:String, var duration:Int) {
    var earliestStart:Int = 0       //earliest start time for task
    var earliestFinish:Int = 0      //earliest finish time for task
    var latestStart:Int = 0         //latest start time
    var latestFinish:Int =0         //latest finish time
    var totalFloat:Int =0           //difference between earliestStart and latestStart (start wiggle room)
    var previousNodes:ArrayList<CriticalNode> = ArrayList()
    var nextNodes:ArrayList<CriticalNode> = ArrayList()

    override fun toString(): String {
        //return "[\tname: ${this.name}, \nduration: ${this.duration}, \nearliestStart: ${this.earliestStart}, \nearliestFinish: ${this.earliestFinish}, \nlatestStart:${this.latestStart}, \nlatestFinish:${this.latestFinish}, \ntotalFloat:${this.totalFloat}, \npreviousNodes:${this.previousNodes}], \nnextNodes:${this.nextNodes} \n]"
        //return this.name+" "+this.totalFloat
        return "[\tname: ${this.name}, \tduration: ${this.duration}, \tearliestStart: ${this.earliestStart}, \tearliestFinish: ${this.earliestFinish}, \tlatestStart:${this.latestStart}, \tlatestFinish:${this.latestFinish}, \ttotalFloat:${this.totalFloat}\n"
    }


}