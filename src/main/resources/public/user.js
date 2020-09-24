const URL = 'http://localhost:8081';
let users = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};



 const indexEntries = () => {
    fetch(`${URL}/users/`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            users = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    users.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(entry.username));
        row.appendChild(createCell(entry.role.name));
        let x = row.appendChild(createCell(0));
        x.innerHTML = '<button onclick=deleteEntry(' + entry.id + ')>Del</button>';
        row.setAttribute("id", entry.id)
        display.appendChild(row);
    });
};

function deleteEntry(id){
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({"id":id});

    var requestOptions = {
        method: 'DELETE',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8081/users/", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    document.getElementById(id).remove();
}
document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
   // createEntryForm.addEventListener('submit', createEntry);
    indexEntries();
});
