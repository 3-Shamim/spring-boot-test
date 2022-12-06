import axios from "axios";

export class UserService {

    static getAllUser() {
        return axios.get("http://localhost:8080/users")
    }

    static saveUser(data) {
        return axios.post("http://localhost:8080/users/save", data)
    }

}