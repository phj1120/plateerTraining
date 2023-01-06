import axios from "axios";

// await 결과가 나올때까지 기다림
export const getTodoList = async () => {
  const res = await axios.get(`http://localhost/todos`)

  return res.data
}


export const postTodo = async (todo) => {
  const res = await axios.post(`http://localhost/todos`, todo)

  return res.data
}

export const deleteTodo = async (id) =>{
  const res = await axios.delete(`http://localhost/todos/${id}`)

  return res.status == 200
}
