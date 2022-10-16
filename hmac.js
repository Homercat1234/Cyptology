// https://www.youtube.com/watch?v=NuyzuNBFWxQ

const { createHmac } = require("crypto");

const key = "b94d27b9934d3e08a";
const message = "message";

const hmac = createHmac('sha256', key).update(message).digest('hex');

console.log(hmac);