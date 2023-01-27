// 체이닝을 계속 해나가면 복잡해 질 수도
// 이를 간편하게 사용하기 위해 나온 것이 
// async & await 
// promise 대신 무조건 이거 써야 되는 것 아님

// # 사람 예제
// promise
function fetchUserByPomise(){
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            resolve('park')
        }, 1000)}
    )
}
const userByPomise = fetchUserByPomise();
userByPomise.then(console.log)

// async
async function fetchUserByAsync(){
    await new Promise(resolve => setTimeout(resolve, 1000))
    
    return 'park'
}
const userByAsync = fetchUserByAsync();
userByAsync.then(console.log)

// # 과일 예제
function delay(ms){
    return new Promise(resolve => setTimeout(resolve, ms))
}

async function getApple(){
    await delay(1000);
    return '사과'
}

async function getBanana(){
    await delay(1000);
    return '바나나'
}

// 콜백 지옥!
function pickFruits(){
    return getApple().then(apple=>{
        return getBanana().then(banana=>{
            return apple +", "+ banana
        })
    })
}
pickFruits().then(console.log)

// await
async function pickFruits(){
    try{
        const apple = await getApple()
        const banana = await getBanana()

        return apple +", "+ banana
    }catch(err){
        console.log(err);
    }
}
pickFruits().then(console.log)

// 병렬 처리
async function pickAllFruits(){
    const applePromise = getApple()
    const bananaPromise = getBanana()

    const apple = await applePromise
    const banana = await bananaPromise

    return apple +", "+ banana
}
pickAllFruits().then(console.log)

async function pickAllFruitsByPromiseAll(){
    return Promise.all([getApple(), getBanana()])
        .then(fruit => fruit.join(', '))
}
pickAllFruitsByPromiseAll().then(console.log)

async function pickOnlyOne(){
    return Promise.race([getApple(), getBanana()])
}
pickOnlyOne().then(console.log)