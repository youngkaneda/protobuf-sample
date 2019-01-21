const axios = require('axios');
const messages = require('./addressbook_pb');

axios({
    url: 'http://localhost:8080/javaee-sample/person',
    method: 'GET',
    responseType: 'arraybuffer',
}).then((res) => {
    const message = messages.Person.deserializeBinary(res.data);
    const person = message.toObject();
    console.log(person);
}, (err) => {
    console.log(err);
});