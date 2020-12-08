import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.PrintWriter
import java.util.*
import kotlin.collections.ArrayList


class Team(var name:String, var leader:String, var list:Collection<String>) {
    init{
        val writerObj = PrintWriter("./src/JSON/teams.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()

    }

    override fun toString(): String {
        return "[name: ${this.name}, leader: ${this.leader}, members:${this.list}]"
    }

    companion object{
        @JvmStatic var masterList: ArrayList<Team> = ArrayList()
        var gsonPretty:Gson = GsonBuilder().setPrettyPrinting().create()

        fun start(){
            try{
                val myType = object : TypeToken<ArrayList<Team>>() {}.type
                masterList = gsonPretty.fromJson(FileReader("./src/JSON/teams.JSON"),myType)
            } catch(e:Exception){
                println("No Teams were loaded from staff.JSON")
            }
            println("Team list found on startup: $masterList")

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