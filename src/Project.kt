import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.PrintWriter

class Project(val name: String) {
    init{
        var writerObj = PrintWriter("./src/JSON/projects.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()
    }

    private fun updateJSON(){
        println("Before loop $masterList")
        for(item in masterList){
            println("$item in $masterList")
            if(item.name == name){
                masterList.remove(item)
                masterList.add(this)
                println("Fucking master list here: $masterList")
                break;
            }
        }
        var writerObj = PrintWriter("./src/JSON/projects.JSON")
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON updated: $jsonString")
        writerObj.write(jsonString)
        writerObj.close()
    }
    var progress:Int = 0
    var tasks : ArrayList<Task> = ArrayList()
    var taskNames : ArrayList<String> = ArrayList();

    fun addTask(task:Task){ //change later to adding task as an object
        println("Adding task to project: $task")
        if(tasks == null) {
            tasks = mutableListOf<Task>(task) as ArrayList<Task>
            taskNames = mutableListOf(task.title) as ArrayList<String>
        } else{
            tasks.add(task)
            taskNames.add(task.title)
        }
        updateJSON()
    }
    override fun toString(): String {
        return "[name: ${this.name}, progress: ${this.progress}, tasks:${this.tasks}]"
    }

    companion object{
        @JvmStatic var masterList: ArrayList<Project> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()

        fun start(){
            try{
                val myType = object : TypeToken<ArrayList<Project>>() {}.type
                masterList = gsonPretty.fromJson(FileReader("./src/JSON/projects.JSON"),myType)
            }catch (e:com.google.gson.JsonSyntaxException){
                println("Syntax error in the JSON file found")
                e.printStackTrace()
            } catch(e:Exception){
                println("No Projects were loaded from projects.JSON")
            }
            println("Project list found on startup: $masterList")

        }
        fun getNames():ArrayList<String>{
            var list:ArrayList<String> = ArrayList<String>()
            for(name in masterList){
                list.add(name.name)
            }
            return list
        }
    }
}