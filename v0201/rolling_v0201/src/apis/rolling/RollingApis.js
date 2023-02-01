import axios from "axios";

// const domain = 'http://192.168.1.127:8080'
const domain = 'http://localhost:8080'

export const addRolling = async (rolling) => {
  const res = await axios.post(`${domain}/rolling`, rolling)
  return res.data
}

export const getRolling = async (id) => {
  const res = await axios.get(`${domain}/api/rollings/${id}`)
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

export const modRolling = async (rolling) => {
  const res = await axios.put(`${domain}/api/rollings/${rolling.id}`, rolling)
  return res.data
}

export const delRolling = async (id) => {
  const res = await axios.delete(`${domain}/api/rollings/${id}`)
  return res.data
}
