<template>
  <v-row>
    <v-col cols="12">
      <h2>{{ targetName }}</h2>
      <v-form class="searchBox">
        <v-btn variant="text" @click="clickAddButton">Add</v-btn>
      </v-form>
    </v-col>
  </v-row>
  <v-row>
    <v-col cols="12">
      <v-card>
        <div class="listWrap">
          <v-card v-for="reply in replies" :loading="loading" :key="reply.id" class="mx-auto my-6 mr-2" width="300"
                  link
                  @click="moveDetail(reply.id)">
            <template v-slot:loader="{ isActive }">
              <v-progress-linear :active="isActive" color="deep-purple" height="4" indeterminate></v-progress-linear>
            </template>
            <v-card-item>
              <v-card-title>{{ reply.title }}</v-card-title>
              <v-card-subtitle>
                <span class="me-1">{{ reply.writer }}</span>
              </v-card-subtitle>
            </v-card-item>
          </v-card>
        </div>
        <!--        <div class="text-center">-->
        <!--          <v-pagination v-model="pageInfo.page" :show-first-last-page="true" :total-visible="pageInfo.pageSize"-->
        <!--                        :length="pageInfo.length" :start="pageInfo.start"-->
        <!--                        @click="() => handleClickPage(pageInfo.page)"></v-pagination>-->
        <!--          <br>-->
        <!--        </div>-->
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup>
  import {ref} from "vue";
  import axios from "axios";
  import {useRoute, useRouter} from "vue-router";

  const searchBox = ref({item: ['ID', 'Name'], searchType: 'ID', searchValue: ''})
  const pageInfo = ref({pageNum: 1, pageSize: 10, length: 13, start: 1})
  const infoLists = ref([])
  const loading = ref(false)

  const router = useRouter()
  const route = useRoute()

  const rollingId = route.params.id;
  const {data} = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/` + rollingId)
  const replies = data.replyDTOs
  const targetName = data.targetName

  const clickAddButton = () => {

  }

  const moveDetail = (id) => {
    router.push({name: 'RollingDetail', params: {'id': id}})
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
