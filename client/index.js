const axios = require('axios');
const messages = require('./addressbook_pb');

axios({
    url: 'http://localhost:8080/protobuf-sample/persons',
    method: 'GET',
    responseType: 'arraybuffer',
}).then((res) => {
    const message = messages.AddressBook.deserializeBinary(res.data);
    const book = message.toObject();
    console.log(book);
}, (err) => {
    console.log(err);
});