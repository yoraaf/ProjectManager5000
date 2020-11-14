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

    var progress:Int = 0
    var tasks : ArrayList<String> = ArrayList()
    var manager: String = ""
    fun addTask(taskName:String){ //change later to adding task as an object
        tasks.add(taskName)
    }
    companion object{
        @JvmStatic var masterList: ArrayList<Project> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()

        fun start(){
            try{
                val myType = object : TypeToken<ArrayList<Project>>() {}.type
                masterList = gsonPretty.fromJson(FileReader("./src/JSON/projects.JSON"),myType)
            } catch(e:Exception){
                println("No Projects were loaded from staff.JSON")
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