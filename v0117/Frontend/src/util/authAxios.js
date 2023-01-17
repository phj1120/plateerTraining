import axios from "axios";
import useMemberInfo from "@/store/useMemberInfo";

const authAxios = axios.create()

const requestRefresh = async () => {
  console.log("[RequestRefresh Start]")
  const {getTokens, saveInfo} = useMemberInfo();
  const tokens = getTokens().value

  // 갱신 요청 전송
  const {data} = await axios.post('http://localhost:8080/api/refresh',
    {access: tokens.access, refresh: tokens.refresh});
  console.log(data)

  // 받아온 정보 클라이언트에 반영
  saveInfo(data.access, data.refresh)
  console.log("[RequestRefresh End]")

  return data
}


authAxios.interceptors.request.use((config) => {
    // authAxios 로 요청 시 헤더에 토큰 넣어 전송
    config.headers = {'Authorization': `Bearer ${useMemberInfo().getTokens().value.access}`}

    return config
  }, () => {
    console.log("[Request 실패 - authAxios.interceptors]")
  }
)

authAxios.interceptors.response.use((response) => {
    return response
  }, async (error) => {
    // 상태코드가 200이 아닐 경우

    // 토큰이 만료된 경우
    if (error.response.data.msg === 'EXPIRED' || error.response.data.msg === 'PLZLOGIN') {
      try {
        const tokens = await requestRefresh()
        error.config.headers = {'Authorization': `Bearer ${tokens.access}`}
        console.log(error.config)
        return axios(error.config)
      } catch (eee) {

        return Promise.reject(error);
      }
    }

    return axios(error.config)
  }
)


export default authAxios
