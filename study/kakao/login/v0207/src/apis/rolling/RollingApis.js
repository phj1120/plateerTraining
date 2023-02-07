import axios from "axios";


const domain = 'http://armysseung.iptime.org:3258'
// const domain = 'http://192.168.1.127:8080'


export const addRolling = async (rollingInfo) => {
  const formData = new FormData();
  formData.append('title', rollingInfo.title)
  formData.append('target', rollingInfo.target)
  if (rollingInfo.files.length != 0) {
    formData.append('thumbnailIndex', rollingInfo.fixFile)

    for (let i = 0; i < rollingInfo.files.length; i++) {
      formData.append(`images[${i}]`, rollingInfo.files[i])
    }
  }

  const res = await axios.post(`${domain}/api/rollings`, formData,
    {headers: {'Content-Type': 'multipart/form-data'}})

  return res.data
}

export const getRollingList = async (pageSearch) => {
  const res = await axios.get(`${domain}/api/rollings/list`, {
    params: {
      page: pageSearch.page || 1, size: pageSearch.size || 10, types: pageSearch.types, keyword: pageSearch.keyword
    }
  })

  return res.data
}

export const getRolling = async ( id ) => {
  const res = await axios.get(`${domain}/api/rollings/${ id }`)
  return res.data
}

// export const modifyRolling = async (rolling) => {
//   const res = await axios.put(`${domain}/api/rollings/${rolling.id}`, rolling)
//   return res.data
// }

export const modifyRolling = async (rollingInfo) => {
  const formData = new FormData();
  formData.append('title', rollingInfo.title)
  formData.append('target', rollingInfo.target)
  console.log(rollingInfo)
  if (rollingInfo.files.length != 0) {
    formData.append('thumbnailIndex', rollingInfo.fixFile)

    for (let i = 0; i < rollingInfo.files.length; i++) {
      formData.append(`images[${i}]`, rollingInfo.files[i])
    }
  }

  const res = await axios.put(`${domain}/api/rollings/${rollingInfo.id}`, formData,
    {headers: {'Content-Type': 'multipart/form-data'}})

  return res.data
}

export const deleteRolling = async (id) => {
  const res = await axios.delete(`${domain}/api/rollings/${id}`)
  return res.data
}

export const getImagePath = (path) => {
  return `${domain}/image/${path}`
}
