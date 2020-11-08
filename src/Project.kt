class Project(val name: String) {
//manager: String , progress: Int , tasks: Array<String>
    var progress:Int = 0;
    var tasks : ArrayList<String> = ArrayList();
    var manager: String = "";
    fun addTask(taskName:String){ //change later to adding task as an object
        tasks.add(taskName);
    }
}