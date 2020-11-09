class Team(): ArrayList<String>() {
    init{
        masterList.add(this)
    }

    companion object{
        @JvmStatic var masterList: ArrayList<Team> = ArrayList()

    }
    //Could add a parameter for a name to the team
}