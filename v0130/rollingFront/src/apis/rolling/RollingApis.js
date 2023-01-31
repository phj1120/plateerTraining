import axios from "axios";

export const addRolling = async (rolling) => {
  const res = await axios.post(`http://192.168.1.123:80/rolling`, {"name": rolling})
  return res.data
}

export const getRollingList = async () => {
  const res = await axios.get("http://192.168.1.123:80/rolling")
  return res.data
}

export const getRolling = async (id) => {
  const res = await axios.get(`http://192.168.1.123:80/rolling/${id}`)
  return res.data
}

export const modifyRolling = async (rolling) => {
  const res = await axios.put(`http://192.168.1.123:80/rolling/${rolling.id}`, rolling)
  return res.data
}

export const deleteRolling = async (id) => {
  const res = await axios.delete(`http://192.168.1.123:80/rolling/${id}`)
  return res.data
}

