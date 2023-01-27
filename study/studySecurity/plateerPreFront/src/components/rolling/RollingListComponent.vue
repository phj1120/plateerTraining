<template>
  <v-row>
    <v-col cols="12">
      <v-btn class="registerBtn" color="info" :to="{name: 'RollingAdd'}">ADD</v-btn>
      <v-btn class="loadBtn" @click="handleClickLoading(pageInfo.page)">load</v-btn>
      <v-form class="searchBox">
        <v-combobox class="searchTypeBox" label="Type" v-model="searchBox.searchType" :items="searchBox.item"
                    variant="underlined"></v-combobox>
        <v-text-field class="searchValueBox" v-model="searchBox.searchValue" label="Keyword" variant="underlined"
                      required></v-text-field>
        <v-btn @click="handleSearch" variant="text" style="margin-top: 0.7em;">Search</v-btn>
      </v-form>
    </v-col>
  </v-row>
  <v-row>
    <v-col cols="12">
      <v-card>
        <div class="listWrap">
          <v-card v-for="info in infoLists" :loading="loading" :key="info.title" class="mx-auto my-6 mr-2" width="300" link
                  @click="moveDetail(info.id)">
            <template v-slot:loader="{ isActive }">
              <v-progress-linear :active="isActive" color="deep-purple" height="4" indeterminate></v-progress-linear>
            </template>
            <v-img cover height="250" :src="info.imgSrc"></v-img>
            <v-card-item>
              <v-card-title>{{ info.target }}</v-card-title>
              <v-card-subtitle>
                <span class="me-1">{{ info.title }} {{info.replyCount}}</span>
              </v-card-subtitle>
            </v-card-item>
          </v-card>
        </div>
        <div class="text-center">
          <v-pagination v-model="pageInfo.page" :show-first-last-page="true" :total-visible="pageInfo.pageSize"
                        :length="pageInfo.length" :start="pageInfo.start"
                        @click="() => handleClickPage(pageInfo.page)"></v-pagination>
          <br>
        </div>
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup>
  import {ref} from "vue";
  import axios from "axios";
  import {useRouter} from "vue-router";

  const searchBox = ref({item: ['Title', 'Name'], searchType: 'Title', searchValue: ''})
  const pageInfo = ref({pageNum: 1, pageSize: 10, length: 13, start: 1})
  const infoLists = ref([])
  const loading = ref(false)

  const {data} = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/getRollingList`)
  infoLists.value = data.dtoList
  pageInfo.value.page = data.pageNum
  pageInfo.value.pageSize = data.pageSize
  pageInfo.value.length = data.totalPageNum
  pageInfo.value.start = data.start
  console.log(data)

  const router = useRouter()
  const moveDetail = (id) => {
    router.push({name: 'RollingDetail', params: {'id': id}})
  }

  const handleClickPage = async (page) => {
    loading.value = true

    const {data} = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/getRollingList?page=${page}`)
    infoLists.value = data.dtoList

    setTimeout(() => {
      loading.value = false
    }, 3000)
  }

  const handleSearch = async () => {
    if (searchBox.value.searchValue === '') {
      alert("Keyword input please")
      console.log('select')
      return
    }

    const {searchType, searchValue} = searchBox.value
    const {data} = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/getSearchRollingList?searchType=${searchType}&searchValue=${searchValue}`)
    infoLists.value = data.dtoList
    pageInfo.value.page = data.pageNum
    pageInfo.value.pageSize = data.pageSize
    pageInfo.value.length = data.totalPageNum
    pageInfo.value.start = data.start

  }

  const handleClickLoading = async (page) => {
    loading.value = true

    const {data} = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/getRollingList?page=${page}`)
    infoLists.value = data.dtoList

    setTimeout(() => {
      loading.value = false
    }, 2000)
  }
</script>

<style scoped>
  .listWrap {
    display: flex;
    flex-wrap: wrap;
    margin: 0 auto;
    /*width: 80vw;*/
    /*height: 90vh;*/
  }

  .loadBtn {
    margin-left: 1em;
  }

  .searchBox {
    display: flex;
    width: 18vw;
    float: right;
  }

  .searchTypeBox {
    width: 6vw;
  }

  .searchValueBox {
    width: 12vw;
  }
</style>
