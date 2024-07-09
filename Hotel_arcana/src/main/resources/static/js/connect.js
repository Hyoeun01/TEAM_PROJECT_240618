async function roomchoice(room_name) {
    url = "/reservation/rooms/"+room_name
    let data = await axios.get(url)

    return data.data
}