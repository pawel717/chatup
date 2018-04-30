package pk.projektzespolowy.chatup.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "username") var username : String,
                @ColumnInfo(name = "password") var password : String)
{
    constructor() : this(null, "", "")
}