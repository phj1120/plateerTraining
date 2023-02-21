import axios from "axios";

const domain = 'http://localhost:8080'

export const getImage = async (path) => {
  console.log(path)
  return await axios.get(`${domain}/image/${path}`)
}
export const getImagePath = (path) => {
  console.log(path)
  return `${domain}/image/${path}`
}
