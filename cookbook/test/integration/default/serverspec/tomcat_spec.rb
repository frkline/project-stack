require 'spec_helper'

# Tomcat
describe service('tomcat') do
  it { should be_enabled   }
  it { should be_running   }
end
describe port(8080) do
  it { should be_listening }
end
describe port(8005) do
  it { should be_listening }
end
