import axios from "axios";

const uri = "http://localhost/todos/"

export const getTodos = async () => {
  return await axios.get(uri).then(
    (response) => {
      return response.data
    }
  )
}

export const postTodo = async (todo) => {
  return await axios.post(uri, todo).then(
    (response) => {
      return response.data
    }
  )
}

export const deleteTodo = async (id) => {
  return await axios.delete(uri + id).then(
    (response) => {
      return response.data
    }
  )
}

export const putTodo = async (id, todo) => {
  return await axios.put(uri + id, todo).then(
    (response) => {
      return response.data
    }
  )
}
