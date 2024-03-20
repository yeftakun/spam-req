const { default: axios } = require("axios");
require('dotenv').config();

const token = process.env.BOT_TOKEN;
const message = process.env.MESSAGE;
const chatId = process.env.CHAT_ID;

const url = `https://api.telegram.org/bot${token}/sendMessage?parse_mode=markdown&chat_id=${chatId}&text=${message}`;

async function sendMessage() {
    try {
        while (true) {
            await axios.get(url)
                .then((response) => {
                    if (response.status == 200) {
                        console.log(response.statusText)
                    } else {
                        console.log("message failed!")
                    }
                })
        }

    } catch (e) {
        sendMessage();
    }
}


sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
sendMessage();
