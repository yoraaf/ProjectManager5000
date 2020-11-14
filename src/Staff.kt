import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.PrintWriter

class Staff(var name:String){
    init{
        var writerObj = PrintWriter("./src/JSON/staff.JSON")
        masterList.add(this)
        val jsonString = gsonPretty.toJson(masterList)
        println("JSON: $jsonString")
        println("MasterList $masterList")
        writerObj.write(jsonString)
        writerObj.close()
    }
    override fun toString(): String {
        return name
    }
    companion object{
        var masterList: ArrayList<Staff> = ArrayList()
        var gsonPretty: Gson = GsonBuilder().setPrettyPrinting().create()
        fun start(){
            val myType = object : TypeToken<ArrayList<Staff>>() {}.type
            try {
                var list: ArrayList<Staff> = gsonPretty.fromJson(FileReader("./src/JSON/staff.JSON"), myType)
                if(list != null){
                    masterList = list
                }
            } catch(e:Exception){
                println("No names were loaded from staff.JSON")
            }
            println("Staff list found on startup: $masterList")

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