import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.PrintWriter

class Task (var title :String, var assignedTeam:Team, var timeFrame: Int){
    init{
        var writerObj = PrintWriter("./src/JSON/tasks.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()
    }
    var progress:Int = 0
    //lateinit var assignedTeam:Team
    var subsequentTask: ArrayList<Task> = ArrayList()

    //var timeFrame: Int = 0 //Duration of task in hours

    fun addPre(pre:Task){
        if(pre.subsequentTask == null){
            pre.subsequentTask = mutableListOf(this) as ArrayList<Task>
        } else {
            pre.subsequentTask.add(this)
        }
    }

    override fun toString(): String {
        return title
    }
    companion object {
        @JvmStatic
        var masterList: ArrayList<Task> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()

        fun start() {
            try {
                val myType = object : TypeToken<ArrayList<Task>>() {}.type
                masterList = gsonPretty.fromJson(FileReader("./src/JSON/tasks.JSON"), myType)
            } catch (e: Exception) {
                println("No Tasks were loaded from tasks.JSON")
            }
            println("Task list found on startup: $masterList")

        }
        fun getNames():ArrayList<String>{
            var list:ArrayList<String> = ArrayList<String>()
            for(task in masterList){
                list.add(task.title)
            }
            return list
        }
    }
}