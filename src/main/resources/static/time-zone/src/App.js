import React, {useEffect, useState} from 'react';
import {UserService} from "./UserService";
import moment from "moment";

const App = () => {

    const [users, setUsers] = useState([]);

    useEffect(() => {

        UserService.getAllUser().then(res => {
            setUsers(res.data);
        }).catch(err => console.error(err));

    }, [])


    const addNewUser = () => {

        // const date = moment("2022-12-06 00:00:00", "YYYY-MM-DD hh:mm:ss").utc(false).format("DD-MM-YYYY hh:mm:ss");
        const date = moment.utc("2022-12-06 00:00:00", "YYYY-MM-DD HH:mm:ss").format("DD-MM-YYYY HH:mm:ss");
        const date1 = moment.utc("2022-12-06 00:00:00", "YYYY-MM-DD HH:mm:ss").local().format("DD-MM-YYYY HH:mm:ss");
        const date2 = moment("2022-12-06 00:00:00", "YYYY-MM-DD HH:mm:ss").utc().format("DD-MM-YYYY HH:mm:ss");
        console.log(date, date1, date2);

        const user = {
            "name": "Test user",
            "dob": "12-06-2022",
            "dateOfBirth": date2,
            // "dateOfBirth": "2022-12-06T06:00:00Z",
            // "dateOfBirth": "12-06-2022 06:00:00",
            // "dateOfBirth": "1670308127076",
        }

        UserService.saveUser(user)
            .then(res => {
                console.log(res.data)
                setUsers(prev => ([...prev, res.data]));
            }).catch(err => console.error(err));
    }

    return (
        <div className="App">
            <div onClick={addNewUser}>
                Add New User
            </div>
            {
                users.map(user => <div key={user.id} style={{
                    backgroundColor: "#eeeeee",
                    padding: "10px",
                    marginBottom: "5px"
                }}>
                    <p>Name: {user.name}</p>
                    <p>DOB: {user.dob}</p>
                    <p>Date of birth: {moment.utc(user.dateOfBirth, "DD-MM-YYYY HH:mm:ss").local().format("DD-MM-YYYY HH:mm:ss")}</p>
                    <p>Created at: {user.createdAt}</p>
                </div>)
            }
        </div>
    );
}

export default App;
