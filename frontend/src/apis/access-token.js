import axios from 'axios'

export async function getAccessToken(code) {
  try {
    const response = await axios.get(
      `http://ec2-13-124-116-59.ap-northeast-2.compute.amazonaws.com:8080/YoutubeCreator/getData`,
      {
        params: { code },
      },
    )
    return response.data
  } catch (error) {
    console.log(error)
    return null
  }
}
