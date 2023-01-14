import axios from "axios";

const uri = "http://localhost:8080/api/todos/"

export const getTodoList = async () => {
  const result = await axios.get(uri)

  return result.data.dtoList
}

export const getTodo = async (id) => {
  const result = await axios.get(uri + id)

  return result.data.data
}

export const postTodo = async (todo) => {
  const result = await axios.post(uri, todo)

  return result.data
}

export const putTodo = async (todo) => {
  const result = await axios.put(uri + todo.id, todo)
  return result.data;
}


export const deleteTodo = async (id) => {
  const result = await axios.delete(uri + id)

  return result.data
}
