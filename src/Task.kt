class Task (var title :String){
    var description:String = ""
    var progress:Int = 0
    lateinit var assignedTeam:Team
    var subsequentTask: Task? = null
    var timeFrame: Int = 0 //Duration of task in hours


}