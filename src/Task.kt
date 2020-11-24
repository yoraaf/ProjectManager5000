
class Task (var name :String, var assignedTeam:Team, var timeFrame: Int){
    var progress:Boolean = false
    var subsequentTasks: ArrayList<String> = ArrayList()

    fun addPre(pre:Task){
        if(pre.subsequentTasks == null){
            pre.subsequentTasks = mutableListOf(this.name) as ArrayList<String>
        } else {
            pre.subsequentTasks.add(this.name)
        }
    }

    override fun toString(): String {
        return name
    }

}