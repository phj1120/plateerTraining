<template>
  <div class="container">
    <div>
      <ProductList :products="productArr" @addCart="addCart"></ProductList>
    </div>
    <div>
      <CartComponent :cart="cart" @change="change"></CartComponent>
    </div>
  </div>
</template>

<script setup>

import ProductList from "@/components/ProductList.vue";
import CartComponent from "@/components/CartComponent.vue";
import {ref} from "vue";
import {getTodoList} from "@/apis/todoAPI";

const todos = getTodoList()

console.log(todos)

const productArr = [
  {
    id: 1, name: '씨그램', url: "https://sitem.ssgcdn.com/35/82/50/item/1000012508235_i1_250.jpg", price: 1000
  },
  {
    id: 2,
    name: '하늘보리',
    url: "https://img.danawa.com/prod_img/500000/940/179/img/3179940_1.jpg?shrink=330:330&_v=20220413175445",
    price: 1000
  },
  {id: 3, name: '헛개차', url: "https://www.ekdp.com/upload/product/hut_last(0).jpg", price: 1000},
  {
    id: 4,
    name: '매일우유',
    url: "https://img.danawa.com/prod_img/500000/234/660/img/1660234_1.jpg?shrink=330:330&_v=20180524151625",
    price: 1000
  },
  {
    id: 5,
    name: '핫식스',
    url: "https://img.danawa.com/prod_img/500000/231/686/img/1686231_1.jpg?shrink=330:330&_v=20220902124631",
    price: 1000
  },
  {
    id: 6,
    name: '코카콜라',
    url: "https://img.danawa.com/prod_img/500000/763/904/img/904763_1.jpg?shrink=330:330&_v=20200616095718",
    price: 1000
  },
]

const cart = ref([])

const addCart = (product) => {
  let item = cart.value.find((element) => {
    return element.item.id === product.id
  })
  if (!item) {
    cart.value.push({item: product, qty: 1})
    return
  }
  item.qty += 1
}

const change = (id, amount) => {
  const temp = cart.value.find(e => e.item.id === id)
  temp.qty += amount
  if (temp.qty <= 0) {
    cart.value = cart.value.filter((e) => e.item.id !== id)
  }
}

</script>

<style scoped>
.container {
  display: flex;
}
</style>
