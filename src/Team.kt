import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.PrintWriter


class Team(var name:String, var leader:String, var list:Collection<String>) {
    init{
        var writerObj = PrintWriter("./src/JSON/teams.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()

    }

    override fun toString(): String {
        return "Category [name: ${this.name}, leader: ${this.leader}, members:${this.list}]"
    }
    //var leader:String = "";
    companion object{
        @JvmStatic var masterList: ArrayList<Team> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()

    }
    //Could add a parameter for a name to the team
}