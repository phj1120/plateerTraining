import axios from "axios";

const domain = 'http://localhost:8080'

// const paging = ref({page: null, size: null})
export const getRollings = async (paging) => {
  // console.log('rollingApi.getRollings')
  // console.log(paging)
  paging.page = paging.page || 1
  paging.size = paging.size || 10

  const res = await axios.get(`${domain}/api/rollings/list?`, {params: paging})

  return res.data
}
