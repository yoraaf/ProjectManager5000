import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.PrintWriter

class Project(val name: String) {
    init{
        val writerObj = PrintWriter("./src/JSON/projects.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()
    }
    var progress:Int = 0
    var tasks : ArrayList<Task> = ArrayList()
    var taskNames : ArrayList<String> = ArrayList();

    fun updateMasterList(){ //update 'this' in the masterList
        for(item in masterList){
            if(item.name == name){
                val index:Int = masterList.indexOf(item)
                masterList[index] = this
                break;
            }
        }
        updateJSON()
    }
    private fun updateJSON(){ //update the actual JSON file
        val writerObj = PrintWriter("./src/JSON/projects.JSON")
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON updated: PROJECT")
        writerObj.write(jsonString)
        writerObj.close()
    }

    fun addTask(task:Task){
        println("Adding task to project: $task")
        if(tasks == null) {
            tasks = mutableListOf<Task>(task) as ArrayList<Task>
            taskNames = mutableListOf(task.name) as ArrayList<String>
        } else{
            tasks.add(task)
            taskNames.add(task.name)
        }
        updateMasterList()
    }
    fun removeTask(task:Task){
        println("removing $task")
        tasks.remove(task)
        taskNames.remove(task.name)
        updateJSON()
    }

    override fun toString(): String {
        return "[name: ${this.name}, progress: ${this.progress}, tasks:${this.tasks}]"
    }

    companion object{
        var masterList: ArrayList<Project> = ArrayList()
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
            val list:ArrayList<String> = ArrayList()
            for(name in masterList){
                list.add(name.name)
            }
            return list
        }
    }
}