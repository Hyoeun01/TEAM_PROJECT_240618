async function uploadToServer (formObj){
    console.log(formObj)
    console.log("upload to server....")

    const response = await axios({
        method: 'POST',
        url: '/upload',
        data: formObj,
        header: {
            'Content-Type': 'multipart/form-data',
        },
    });
    return response.data
}
async function removeFileToServer(uuid, fileName){
    const response = await axios.delete(`/remove/${uuid}_${fileName}`)
    return response.data
}