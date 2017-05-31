package sport.tsse.com.sportapp.chat

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.slyce.messaging.SlyceMessagingFragment
import it.slyce.messaging.listeners.LoadMoreMessagesListener
import it.slyce.messaging.listeners.UserSendsMessageListener
import it.slyce.messaging.message.Message
import it.slyce.messaging.message.MessageSource
import it.slyce.messaging.message.TextMessage
import kotlinx.android.synthetic.main.fragment_chat.*
import sport.tsse.com.sportapp.R
import java.util.*


/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ChatActivity : AppCompatActivity(), UserSendsMessageListener, LoadMoreMessagesListener {
    override fun loadMoreMessages(): ArrayList<Message> {
        val messages = ArrayList<Message>()
        for (i in 0..49)
            messages.add(getRandomMessage())
        return messages
    }

    var n = 0
    private fun getRandomMessage(): Message {
        n++
        val textMessage = TextMessage()
        textMessage.text = "" + n + "" // +  ": " + latin[(int) (Math.random() * 10)]);
        textMessage.date = Date().getTime()
        if (Math.random() > 0.5) {
            textMessage.avatarUrl = "https://lh3.googleusercontent.com/-Y86IN-vEObo/AAAAAAAAAAI/AAAAAAAKyAM/6bec6LqLXXA/s0-c-k-no-ns/photo.jpg"
            textMessage.userId = "LP"
            textMessage.source = MessageSource.EXTERNAL_USER
        } else {
            textMessage.avatarUrl = "https://scontent-lga3-1.xx.fbcdn.net/v/t1.0-9/10989174_799389040149643_722795835011402620_n.jpg?oh=bff552835c414974cc446043ac3c70ca&oe=580717A5"
            textMessage.userId = "MP"
            textMessage.source = MessageSource.LOCAL_USER
        }
        return textMessage
    }

    override fun onUserSendsMediaMessage(imageUri: Uri?) {
    }

    override fun onUserSendsTextMessage(text: String?) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_chat)

        val slyceMessagingFragment = fragmentManager.findFragmentById(R.id.messaging_fragment) as SlyceMessagingFragment
        slyceMessagingFragment.setDefaultAvatarUrl("https://scontent-lga3-1.xx.fbcdn.net/v/t1.0-9/10989174_799389040149643_722795835011402620_n.jpg?oh=bff552835c414974cc446043ac3c70ca&oe=580717A5")
        slyceMessagingFragment.setDefaultDisplayName("Matthew Page")
        slyceMessagingFragment.setDefaultUserId("uhtnaeohnuoenhaeuonthhntouaetnheuontheuo")

        slyceMessagingFragment.setOnSendMessageListener(this)

        slyceMessagingFragment.setLoadMoreMessagesListener(this)

        slyceMessagingFragment.setMoreMessagesExist(true)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)

            toolbar.setNavigationOnClickListener({
                onBackPressed()
            })
        }
    }

    companion object {
        private var n = 0
        private val latin = arrayOf("Vestibulum dignissim enim a mauris malesuada fermentum. Vivamus tristique consequat turpis, pellentesque.", "Quisque nulla leo, venenatis ut augue nec, dictum gravida nibh. Donec augue nisi, volutpat nec libero.", "Cras varius risus a magna egestas.", "Mauris tristique est eget massa mattis iaculis. Aenean sed purus tempus, vestibulum ante eget, vulputate mi. Pellentesque hendrerit luctus tempus. Cras feugiat orci.", "Morbi ullamcorper, sapien mattis viverra facilisis, nisi urna sagittis nisi, at luctus lectus elit.", "Phasellus porttitor fermentum neque. In semper, libero id mollis.", "Praesent fermentum hendrerit leo, ac rutrum ipsum vestibulum at. Curabitur pellentesque augue.", "Mauris finibus mi commodo molestie placerat. Curabitur aliquam metus vitae erat vehicula ultricies. Sed non quam nunc.", "Praesent vel velit at turpis vestibulum eleifend ac vehicula leo. Nunc lacinia tellus eget ipsum consequat fermentum. Nam purus erat, mollis sed ullamcorper nec, efficitur.", "Suspendisse volutpat enim eros, et.")

        private // +  ": " + latin[(int) (Math.random() * 10)]);
        val randomMessage: Message
            get() {
                n++
                val textMessage = TextMessage()
                textMessage.text = n.toString() + ""
                textMessage.date = Date().getTime()
                if (Math.random() > 0.5) {
                    textMessage.avatarUrl = "https://lh3.googleusercontent.com/-Y86IN-vEObo/AAAAAAAAAAI/AAAAAAAKyAM/6bec6LqLXXA/s0-c-k-no-ns/photo.jpg"
                    textMessage.userId = "LP"
                    textMessage.source = MessageSource.EXTERNAL_USER
                } else {
                    textMessage.avatarUrl = "https://scontent-lga3-1.xx.fbcdn.net/v/t1.0-9/10989174_799389040149643_722795835011402620_n.jpg?oh=bff552835c414974cc446043ac3c70ca&oe=580717A5"
                    textMessage.userId = "MP"
                    textMessage.source = MessageSource.LOCAL_USER
                }
                return textMessage
            }
    }
}