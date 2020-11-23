import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.PrintWriter

class Task (var title :String, var assignedTeam:Team, var timeFrame: Int){
    init{
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("MasterList $masterList")
        updateJSON()
    }
    var progress:Boolean = false
    //lateinit var assignedTeam:Team
    var subsequentTasks: ArrayList<String> = ArrayList()

    //var timeFrame: Int = 0 //Duration of task in hours
    fun updateThisInJSON(){
        println("Before loop $masterList")
        for(item in masterList){
            println("$item in $masterList")
            if(item.title == title){
                var index:Int = masterList.indexOf(item)
                masterList[index] = this
                break;
            }
        }
        updateJSON()
    }
    fun updateJSON(){
        var writerObj = PrintWriter("./src/JSON/tasks.JSON")
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON updated: $jsonString")
        writerObj.write(jsonString)
        writerObj.close()
    }
    fun addPre(pre:Task){
        if(pre.subsequentTasks == null){
            pre.subsequentTasks = mutableListOf(this.title) as ArrayList<String>
        } else {
            pre.subsequentTasks.add(this.title)
        }
        pre.updateThisInJSON()
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