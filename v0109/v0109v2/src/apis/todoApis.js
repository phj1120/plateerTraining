import axios from "axios";

const uri = 'http://localhost/todos/'
export const getTodoList = async () => {
  const result = await axios.get(uri)

  return result.data
}

export const getTodo = async (id) => {
  console.log(id)
  const result = await axios.get(uri + id)


  return result.data
}

export const postTodo = async (todo) => {
  const result = await axios.post(uri, todo)

  return result.data
}
