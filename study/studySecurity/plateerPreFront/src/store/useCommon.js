import {defineStore} from "pinia";

const useCommon = defineStore('useCommon', () => {

  const getTodayFormat = () => {
    let date = new Date()
    return date.getFullYear() + '-' + ((date.getMonth() + 1) < 9 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-' + ((date.getDate()) < 9 ? '0' + (date.getDate()) : date.getDate())
  }

  const getYesterdayFormat = () => {
    let date = new Date()
    return date.getFullYear() + '-' + ((date.getMonth() + 1) < 9 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-' + ((date.getDate()) < 9 ? '0' + (date.getDate() - 1) : date.getDate() - 1)
  }


  return { getTodayFormat, getYesterdayFormat }
})

export default useCommon
