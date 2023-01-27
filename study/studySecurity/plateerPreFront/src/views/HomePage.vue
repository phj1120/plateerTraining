<template>
  <v-row>
    <v-col cols="12">
      <v-card>
        <v-list lines="two">
          <v-list-subheader>{{ cards[0] }}</v-list-subheader>
          <template v-for="(t, index) in todayList" :key="t.id">
            <v-list-item link>
              <template v-slot:prepend>
                <v-avatar color="grey-darken-1"></v-avatar>
              </template>
              <v-list-item-title>{{ t.target }}</v-list-item-title>
              <v-list-item-subtitle>
                {{ t.title }}
              </v-list-item-subtitle>
            </v-list-item>
            <v-divider v-if="(index + 1) !== todayList.length" :key="`divider-${index + 1}`" inset></v-divider>
          </template>
        </v-list>
      </v-card>
    </v-col>
    <v-col :key="card" cols="12">
      <v-card>
        <v-list lines="two">
          <v-list-subheader>{{ cards[1] }}</v-list-subheader>
          <template v-for="(y, index) in yesterdayList" :key="y.id">
            <v-list-item link>
              <template v-slot:prepend>
                <v-avatar color="grey-darken-1"></v-avatar>
              </template>
              <v-list-item-title>{{ y.target }}</v-list-item-title>
              <v-list-item-subtitle>
                {{ y.title }}
              </v-list-item-subtitle>
            </v-list-item>
            <v-divider v-if="(index + 1) !== yesterdayList.length" :key="`divider-${index + 1}`" inset></v-divider>
          </template>
        </v-list>
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup>
  import {ref} from "vue";
  import axios from "axios";
  import logger from "@fortawesome/vue-fontawesome/src/logger";
  import useCommon from "@/store/useCommon";

  const { getTodayFormat, getYesterdayFormat } = useCommon()
  const cards = ref(['Today', 'Yesterday'])

  const todayList = ref([])
  const yesterdayList = ref([])
  const rollingList = ref([])

  const { data } = await axios.get(`http://armysseung.iptime.org:3258/api/rolling/getRollingAllList`)
  rollingList.value = data

  const today = getTodayFormat()
  const yesterday = getYesterdayFormat()
  todayList.value = rollingList.value.filter(ele => ele.createDt === today)
  yesterdayList.value = rollingList.value.filter(ele => ele.createDt === yesterday)

  console.log(todayList)
  console.log(yesterdayList)


</script>

<style scoped>
</style>
