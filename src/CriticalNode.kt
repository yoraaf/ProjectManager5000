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
        return "[\tname: ${this.name}, \nduration: ${this.duration}, \nearliestStart: ${this.earliestStart}, \nearliestFinish: ${this.earliestFinish}, \nlatestStart:${this.latestStart}, \nlatestFinish:${this.latestFinish}, \ntotalFloat:${this.totalFloat}"
    }
    fun isDependent(t: CriticalNode?): Boolean {
        //is t a direct dependency?
        if (nextNodes.contains(t)) {
            return true
        }
        //is t an indirect dependency
        for (dep in nextNodes) {
            if (dep.isDependent(t)) {
                return true
            }
        }
        return false
    }

}