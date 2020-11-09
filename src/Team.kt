import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.PrintWriter


class Team(var name:String, var leader:String, var list:Collection<String>) {
    init{
        val jsonString = gsonPretty.toJson(this)
        println(jsonString)
        writerObj.write(jsonString)
        writerObj.close()
        masterList.add(this)
    }

    override fun toString(): String {
        return "Category [name: ${this.name}, leader: ${this.leader}, members:${this.list}]"
    }
    //var leader:String = "";
    companion object{
        @JvmStatic var masterList: ArrayList<Team> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()
        var writerObj = PrintWriter("./src/JSON/tasks.JSON")

    }
    //Could add a parameter for a name to the team
}