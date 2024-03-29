require 'chefspec'
require_relative 'spec_helper'

describe 'project-stack::default' do
  let(:chef_run) { ChefSpec::Runner.new.converge(described_recipe) }

  it 'includes the nginx::source recipe' do
    expect(chef_run).to include_recipe('nginx::source')
  end

end
