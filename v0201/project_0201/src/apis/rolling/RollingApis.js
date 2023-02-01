import axios from "axios";


const domain = 'http://192.168.1.127:8080'


export const addRolling = async (rolling) => {
  // const res = await axios.post(`http://localhost:8080/rolling/add`, { 'name': rolling })
  const res = await axios.post(`http://localhost:80/rolling`, rolling)
  return res.data
}

export const getRollingList = async (pageDTO, searchDTO) => {

  if (!pageDTO.page) {
    // pageDTO.value = {page: 1, size: 10}
    pageDTO.value.page = 1
    pageDTO.value.size = 10
    console.log(pageDTO.value)

  }
  const page = pageDTO.page
  const size = pageDTO.size


  if (!searchDTO) {
    const res = await axios.get(`${domain}/api/rollings/list?page=${page}&size=${size}`)
    return res.data
  }

  const types = searchDTO.value.types
  const keyword = searchDTO.value.keyword
  const res = await axios.get(`${domain}/api/rollings/list?page=${page}&size=${size}&types=${types}&keyword=${keyword}`)

  return res.data
}

export const getRolling = async (id) => {
  const res = await axios.get(`${domain}/api/rollings/${id}`)
  // const res = await axios.get(`http://localhost:80/rolling/${ id }`)
  return res.data
}

export const modRolling = async (rolling) => {
  const res = await axios.put(`${domain}/api/rollings/${rolling.id}`, rolling)
  // const res = await axios.put(`http://localhost:80/rolling/${ rolling.id }`, rolling)
  return res.data
}

export const delRolling = async (id) => {
  const res = await axios.delete(`${domain}/api/rollings/${id}`)
  // const res = await axios.delete(`http://localhost:80/rolling/${ id }`)
  return res.data
}
