// https://www.youtube.com/watch?v=NuyzuNBFWxQ

const { scryptSync, randomBytes, timingSafeEqual } = require("crypto");
const list = [];

function register(username, password) {
  const salt = randomBytes(16).toString("hex");
  const hashed = scryptSync(password, salt, 64).toString("hex");
  const user = { username, password: `${salt}:${hashed}` };
  list.push(user);
}

function login(username, password) {
  const user = list.find((u) => u.username === username);
  if (!user) return "No";
  const [salt, hashed] = user.password.split(":");

  const hashBuffer = scryptSync(password, salt, 64);
  const keyBuffer = Buffer.from(hashed, "hex");

  const match = timingSafeEqual(hashBuffer, keyBuffer);

  if (match) return "Yes";
  return "No";
}

register("User", "Passwoard");
console.log(login("User", "Password"));